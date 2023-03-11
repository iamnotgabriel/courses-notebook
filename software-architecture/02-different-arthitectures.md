# Layered Architecture

The most common architecture in the market.
Each layer is focused on doing your responsibility
1. Services Layer : Business logic
2. Repositories Layer : Data access and permanence layer
3. Domain Layer : Contains the domain objects 
4. UI Layer : Interacts with the user

While the Layered Architecture is an improvement towards organization it is a
fragile improvement. First the layered architecture is too centered on data
causing to be a direct flow form repository to UI. The lack of intent in the
layered architecture often causes services to accumulate too much data and
responsibilities often leaks between layers.

# Technologies Driven Architecture

Software that is too heavily based on frameworks or any other dependency. This
architecture implies that your business will not outlive the technology. And
only divide different technologies.

# Intent base architecture

This architecture allows the domain to shape the organization of the software.
Often this architecture is made of small pieces name by a part of the domain.
E.g. a Car rental software will contain domains like 'Car', 'Clients',
'Rental'.

In contrast with the Layered architecture that segregate ideas horizontally,
the intent architecture segregates vertically. Additionally, the intent 
architecture is composed of very small layered architectures based the business
context.