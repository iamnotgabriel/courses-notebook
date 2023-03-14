# What is Spring ?
Spring is a dependency injection framework!

# What is dependency
Dependency when a software depends on another layer.

```
public class ComplexBusinessService {
    SortAlgorithm sorter = new SomeAlgorithm();
    ...
}
```

In the example, ComplexBusiness depends on SortAlgorithm. The example is also
tightly coupled with SomeAlgorithm, because ComplexBusinessService directly
calls SomeAlgorithm. to solve this follow the next example:

```
public class ComplexBusinessService {
    SortAlgorithm sorter;
    public ComplexBusinessLogic(SortAlgorithm sorter) {...}
}

public Main {
    public static void main(String[] args) {
        SortAlgorithm sorter = new SortAlgorithm();
        ComplexBusinessLogic business = new ComplexBusinessLogic(sorter);
        ... 
    }
}
```

SpringFramework takes care of that if we annotate the classes that will be
injected with @Component and @Autowired to declare the injected properties.

```
@Component
public class ComplexBusinessService {
    @Autowired
    SortAlgorithm sorter;
    ...
}
```

# Terminology
1. Beans : objects managed by spring (object of classed annotated with @Component)
2. Autowiring : Process of identifying, matching and populating dependencies
3. Dependency Injection : Parameterized dependencies of a piece of code 
4. Inversion of Control : Taking out the control of the absolute dependency of a depended class
5. IOC Container : Inversion Of Control Control, anything that implements IOC 
6. Application Context : The most important IOC Container !important

