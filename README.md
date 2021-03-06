# Challenger Framework

[![Build Status](https://travis-ci.org/slothsoft/framework-challenger.svg?branch=master)](https://travis-ci.org/slothsoft/framework-challenger) [![Maven Central](https://img.shields.io/maven-central/v/de.slothsoft.challenger/core.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22de.slothsoft.challenger%22%20AND%20a:%22core%22)

- **Author:** [Stef Schulz](mailto:s.schulz@slothsoft.de)
- **Repository:** <https://github.com/slothsoft/framework-challenger>
- **Open Issues:** <https://github.com/slothsoft/framework-challenger/issues>
- **Wiki:** none


Sometimes I like to create a little programming challenge. Some of these share code, even though not really, so it only seemed right to have a Maven archetype for these things.



## Getting Started

### Prerequisites

You need at least **Java 8** or above to run the code.


### Using the Framework

The core library is in Maven Central, so you can easily add it like this:

```xml
<dependency>
    <groupId>de.slothsoft.challenger</groupId>
    <artifactId>core</artifactId>
    <version>1.0.0</version>
</dependency>
```

To generate a new project from a Maven archetype, use this line:

```
mvn archetype:generate -DarchetypeGroupId=de.slothsoft.challenger -DarchetypeArtifactId=mapbased-archetype -DarchetypeVersion=1.0.0
```
   

##  Versions


| Version       | Changes       |
| ------------- | ------------- |
| [1.0.0](https://github.com/slothsoft/framework-challenger/milestone/1?closed=1) | first release|
   
   

## Features

- **core** - basic functionality for finding contributions dynamically
- **mapbased-archetype** - Maven archetype for map based challenges like the [tribes challenge](https://github.com/slothsoft/challenge-tribes)


### Map Based Archetype

The resulting project looks something like that:

![Screenshot](https://raw.githubusercontent.com/slothsoft/framework-challenger/master/readme/mapbased.png)

It might be ugly, but you can do fun stuff with it:

- [tribes challenge](https://github.com/slothsoft/challenge-tribes)


## License

This project is licensed under the MIT License - see the [MIT license](https://opensource.org/licenses/MIT) for details.
