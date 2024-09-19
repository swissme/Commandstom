plugins {
    id("java")
    id("java-library")
}

group = "net.minesprawl"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    api("org.incendo:cloud-core:2.0.0")
    api("net.minestom:minestom-snapshots:d0754f2a15")
}

tasks.test {
    useJUnitPlatform()
}