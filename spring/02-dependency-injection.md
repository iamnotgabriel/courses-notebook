# Dependency Injection
With Spring, injections are when the application starts. To inject a dependency
Spring needs two Beans( injected and the to be injected) and matching type.
A matching type can be one of the following:
 1. A explicit dependency `@Autowired InjectedClass injectedProperty`
 2. A implicit dependency with only one implementation `@Autowired Injectable injectedProperty`
 3. A implicit dependency with a `@Primary` in one of the implementations
 4. A implicit dependency with a matching name `@Autowired Injectable injectedInterfaceImplementation`
 5. Using Qualifiers

# 1 
```
@Component
class ClassThatDoesSomething {
    @Autowired
    InjectedClass injectedProperty
}

@Component
class InjectedClass {
    ...
}
```


# 2
```
interface Injectable {
    void aMethod();
}

@Component
class ClassThatDoesSomething {
    @Autowired
    Injectable injectable;
}

@Component
class InjectedClass implements Injectable {
    ...
}
```

# 3
```
interface Injectable {
    void aMethod();
}

@Component
class ClassThatDoesSomething {
    @Autowired
    Injectable injectable;
}

@Component
@Primary
class FirstInjectedClass implements Injectable {
    ...
}

@Component
class SecondInjectedClass implements Injectable {
    ...
}
```

# 3
```
interface Injectable {
    void aMethod();
}

@Component
class ClassThatDoesSomething {
    @Autowired
    Injectable injectable;
}

@Component
@Primary
class FirstInjectedClass implements Injectable {
    ...
}

@Component
class SecondInjectedClass implements Injectable {
    ...
}
```

# 4
```
interface Injectable {
    void aMethod();
}

@Component
class ClassThatDoesSomething {
    @Autowired
    Injectable secondInjectedClass;
}

@Component
class FirstInjectedClass implements Injectable {
    ...
}

@Component
class SecondInjectedClass implements Injectable {
    ...
}
```

# 5
```
interface Injectable {
    void aMethod();
}

@Component
class ClassThatDoesSomething {
    @Autowired
    @Qualifier("first")
    Injectable injectable;
}

@Component
@Qualifier("first")
class FirstInjectedClass implements Injectable {
    ...
}

@Component
@Qualifier("second")
class SecondInjectedClass implements Injectable {
    ...
}
```
