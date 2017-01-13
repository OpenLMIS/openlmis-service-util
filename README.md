# OpenLMIS Service Util
This library contains code that is shared between Services.

## Prerequisites
* Docker 1.11+

## Quick Start
1. Fork/clone this repository from GitHub.

 ```shell
 git clone https://github.com/OpenLMIS/openlmis-service-util.git
 ```
2. Assemble the outputs of project and create jar file by running `docker-compose run builder`.


## <a name="service-dependency"></a> Including this library in a service
1. Add OSS Snapshot under `repositories` section of `build.gradle`.
 ```
maven { url "https://oss.sonatype.org/content/repositories/snapshots" }
 ```
 2. Modify `dependencies` to include openlmis-service-util.
 ```
 compile 'org.openlmis:openlmis-service-util:3.0.0-SNAPSHOT'
 ```

## <a name="adding-classes"></a> Adding shared classes

When adding utilities to this library:
 * Do not use Spring dependencies
 * When adding dependent libraries that may also be used in the services, be careful about their versions. Make sure there are no conflicts.
 * Add only Java classes
