plugins {
	java
	id("org.springframework.boot") version "3.4.1"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.ambrose"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-web")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("com.mysql:mysql-connector-j")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("software.amazon.awssdk:s3")
	implementation("software.amazon.awssdk:auth")
	implementation("com.amazonaws:aws-java-sdk-s3:1.12.559")
	implementation("software.amazon.awssdk:s3:2.17.105")  // AWS SDK for S3
	implementation("software.amazon.awssdk:auth:2.17.105")
	implementation("org.springframework.security:spring-security-crypto:6.1.0")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
