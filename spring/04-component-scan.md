# Component scan
To autowire a bean, spring needs to find this bean the application first. It
does that with a component scan, whenever SpringBootApplication is annotated,
a component scan is made in this package and all the sub packages.
To create beans in another package, annotate the main class with the 
ComponentScan annotation like the example


```
package com.organization.product.api;

@SpringBootApplication
@ComponentScan("com.organization.product.use_cases")
public class MySpringBootApplication { ... }
```

