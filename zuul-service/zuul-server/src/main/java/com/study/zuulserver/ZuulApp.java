package com.study.zuulserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.Route;
import org.springframework.cloud.netflix.zuul.filters.RouteLocator;
import org.springframework.cloud.netflix.zuul.filters.ZuulProperties;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 我走路带风
 * @since 2020/11/6 9:12
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
@EnableSwagger2
public class ZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApp.class);
    }

    @Autowired
    private RouteLocator routeLocator;

    //zuul的配置可以通过配置中心动态更新
    @RefreshScope
    @ConfigurationProperties("zuul")
    public ZuulProperties zuulProperties(){
        return new ZuulProperties();
    }

    //添加接口文档
    @Component
    @Primary
    class DocumentationConfig implements SwaggerResourcesProvider{
        @Override
        public List<SwaggerResource> get() {
            List resources = new ArrayList<>();
            //获取所有router
            List<Route> routes = routeLocator.getRoutes();
            for (Route route:routes){
                resources.add(swaggerResource(route.getId(), route.getFullPath().replace("**", "v2/api-docs"),"2.0"));
            }
            return resources;
        }

        private SwaggerResource swaggerResource(String name,String location,String version){
            SwaggerResource swaggerResource = new SwaggerResource();
            swaggerResource.setName(name);
            swaggerResource.setLocation(location);
            swaggerResource.setSwaggerVersion(version);
            return swaggerResource;
        }
    }

}
