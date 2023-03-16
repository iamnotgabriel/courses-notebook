# Bean lifecycle

* singleton - 1 bean per Spring Context (default)
* prototype - New bean whenever requested
* request - 1 bean per HTTP request
* session - 1 bean per HTTP session

Choose the scope with a annotation as the example 
```
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
class LifecycleExample {}
```

# Interactions

When a class is annotated with a singleton scope, and a injected property is
scoped as prototype (or any other type). The property (although prototype) will
be loaded only once. To solve is issue use a proxy.

```
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE,
    proxyMode = ScopedProxyMode.TARGET_CLASS)
class LifeCycleExample  {...}
```

# Difference between GOF Singleton and Spring

The traditional Singleton pattern establishes there should be only one object
per process. In spring singleton mean **one object per application context**.

# PostConstruct

The bean method annotated with @PostConstruct will be called just after the
bean is created and all properties are initialized.

# ProDestroy

The bean method annotated with @PreDestroy will be called just before the bean
is removed from the container.