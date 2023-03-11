# Clean architecture

Solves the problems of intent architecture and the technology architecture.
Onion Architecture derives from layered architecture. This architecture 
divides your software in a core layer and many other that depends to every
thing that is inside.

1. **Core layer** : Contains the main objective of the software
2. **Use cases** : Contains the intent of the software and only depends on the core
3. **UI** : Presents the Use cases and Core to the user
4. **DB** : Depends on the use cases and Core

# Plugins

Construct software that depends on abstractions and than build plugins
implementing the abstractions. In practice it means that each use case defines
their own dependencies with interfaces, and the repository or other plugins 
depends on the core of the application.

# Adding intent to the clear 

Constructing use cases with one clear responsibility, add the intent of 
software by describing clearly every action made within the software.

# Be prepared for changes

The clean architecture allows you to change the software technologies and
external dependency by using segregating them as plugins

# Promoting a better workflow

With clean architecture you are induced to think first about the business core
and use cases to then think about what will be done to complete the use case.

# Helping Test Driven development

Centering your software around the use cases allow to easily test it according
to your need (unit or integration testing). The similarity of test cases and 
use cases also promote better tests.