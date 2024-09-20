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
    api("net.minestom:minestom-snapshots:d0754f2a15")

    compileOnly("org.projectlombok:lombok:1.18.34")
    annotationProcessor("org.projectlombok:lombok:1.18.34")
    implementation("com.google.guava:guava:11.0.2")
}

tasks.test {
    useJUnitPlatform()
}