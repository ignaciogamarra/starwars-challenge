plugins {
    id("java")
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.springframework.boot") version "3.5.3"
}

group = "com.inditex.sisushipbk"
version = "1.0-SNAPSHOT"

val versions = mapOf(
    "jackson" to "2.17.2",
    "lombok" to "1.18.30",
    "mapstruct" to "1.5.5.Final",
    "junitBom" to "5.10.0",
    "mockitoCore" to "5.5.0",
    "mockitoJUnit" to "5.5.0",
    "assertjCore" to "3.24.2",
    "lombokMapstructBinding" to "0.2.0"
)

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.core:jackson-databind:${versions["jackson"]}")
    implementation("org.projectlombok:lombok:${versions["lombok"]}")
    implementation("org.mapstruct:mapstruct:${versions["mapstruct"]}")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:${versions["junitBom"]}"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:${versions["mockitoCore"]}")
    testImplementation("org.mockito:mockito-junit-jupiter:${versions["mockitoJUnit"]}")
    testImplementation("org.assertj:assertj-core:${versions["assertjCore"]}")
    annotationProcessor("org.mapstruct:mapstruct-processor:${versions["mapstruct"]}")
    annotationProcessor("org.projectlombok:lombok:${versions["lombok"]}")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:${versions["lombokMapstructBinding"]}")
}

tasks.test {
    useJUnitPlatform()
}