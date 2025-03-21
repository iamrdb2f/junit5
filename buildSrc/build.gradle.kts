import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	`kotlin-dsl`
	id("com.github.ben-manes.versions") version "0.44.0"
}

repositories {
	gradlePluginPortal()
}

dependencies {
	implementation(kotlin("gradle-plugin"))
	implementation("biz.aQute.bnd:biz.aQute.bnd.gradle:6.4.0")
	implementation("com.diffplug.spotless:spotless-plugin-gradle:6.14.0")
	implementation("com.github.ben-manes:gradle-versions-plugin:0.44.0")
	implementation("gradle.plugin.com.github.johnrengelman:shadow:7.1.2")
	compileOnly("com.gradle:gradle-enterprise-gradle-plugin:3.12.2") // keep in sync with root settings.gradle.kts
}

tasks {
	withType<JavaCompile>().configureEach {
		options.release.set(8)
	}
	withType<KotlinCompile>().configureEach {
		kotlinOptions {
			jvmTarget = "1.8"
			allWarningsAsErrors = true
		}
	}
}
