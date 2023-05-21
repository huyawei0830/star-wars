# Star Wars Information Service

### Assumptions
- The url to entity (people/starship/planet) mapping as well as the entity names will not change
- The other attributes of the entities might be subjective to changes
- If Darth Vader has multiple starships, the first one is returned since it requires only one starship in the response

### Design Consideration
- To make it efficient to query people and starship by name, the name to entity mapping is retrieved and cached in memory upon service startup
- Make the actual api calls https://swapi.dev/ to get the latest information of the entities
- It might take a couple of seconds to start up the service due to the service calls to initialize the cache