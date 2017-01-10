# OpenLMIS Service Util
This library contains code that is shared between Services.

## Prerequisites
* Gradle 2.14+

## Quick Start
1. Fork/clone this repository from GitHub.

 ```shell
 git clone https://github.com/OpenLMIS/openlmis-service-util.git
 ```
2. Assemble the outputs of project and create jar file by running `gradle assemble`.

## <a name="adding-classes"></a> Adding shared classes

When adding utilities to this library:
 * Do not use Spring dependencies
 * When adding dependent libraries that may also be used in the services, be careful about their versions. Make sure there are no conflicts.
 * Add only Java classes
