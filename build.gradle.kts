import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.0"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	id("com.arenagod.gradle.MybatisGenerator") version "1.4"

	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
}

allprojects {
	group = "com.orangeman.example"
	version = "0.0.1-SNAPSHOT"
	java.sourceCompatibility = JavaVersion.VERSION_1_8

	repositories {
		mavenCentral()
	}

	apply(plugin = "io.spring.dependency-management")
	dependencyManagement {
		dependencies {
			dependency("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.4")
			dependency("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1")
			dependency("org.mybatis.generator:mybatis-generator-core:1.4.0")
		}
	}
}

mybatisGenerator {
	verbose = true
	configFile = "mybatisGeneratorConfig.xml"
	dependencies {
		mybatisGenerator("org.mybatis.generator:mybatis-generator-core")
		mybatisGenerator("mysql:mysql-connector-java")
	}
}


dependencies {
	implementation("org.springframework.boot:spring-boot-starter-security")
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.flywaydb:flyway-core")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.thymeleaf.extras:thymeleaf-extras-springsecurity5")
	implementation("mysql:mysql-connector-java")
	implementation("org.mybatis.spring.boot:mybatis-spring-boot-starter:2.1.4")
	implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.2.1")
	implementation("org.mybatis.generator:mybatis-generator-core:1.4.0")

	developmentOnly("org.springframework.boot:spring-boot-devtools")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.security:spring-security-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
