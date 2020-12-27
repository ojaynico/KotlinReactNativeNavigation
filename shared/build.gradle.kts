plugins {
    id("org.jetbrains.kotlin.js") version "1.4.10"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }
    maven { url = uri("https://dl.bintray.com/ojaynico/ojaynico-kotlin-react-native") }
    maven { setUrl("https://dl.bintray.com/ojaynico/ojaynico-kotlin-react-native-navigation") }
    jcenter()
    maven { url = uri("http://dl.bintray.com/kotlin/kotlin-js-wrappers") }
    maven { url = uri("https://dl.bintray.com/kotlin/kotlinx") }
    mavenLocal()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    implementation("org.jetbrains:kotlin-react:16.13.1-pre.120-kotlin-1.4.10")
    implementation("org.jetbrains:kotlin-extensions:1.0.1-pre.120-kotlin-1.4.10")
    implementation("ojaynico.kotlin.react.native:ojaynico-kotlin-react-native:1.0.6")
    implementation("ojaynico.kotlin.react.native.navigation:ojaynico-kotlin-react-native-navigation:1.0.1")
    implementation(npm("react", "16.13.1"))
    implementation(npm("react-native", "0.63.3"))
    implementation(npm("react-native-navigation", "7.6.0"))
    implementation(npm("react-native-navigation-drawer-extension", "3.2.0"))
}

kotlin {
    js {
        nodejs {
        }
        useCommonJs()
    }
}

task("deletePackages") {
    doLast {
        delete("build/js/packages/shared/package.json")
        delete("build/js/package.json")
        delete("build/js/packages_imported/kotlin/1.4.10/package.json")
        delete("build/js/packages_imported/kotlin/1.3.72/package.json")
        delete("build/js/packages_imported/kotlin-wrappers-kotlin-react-jsLegacy/1.0.0-SNAPSHOT/package.json")
        delete("build/tmp/expandedArchives/kotlin-react-16.13.1-pre.120-kotlin-1.4.10.jar_c72db421223d4484036541e379b08c49/package.json")
    }
}

tasks {
    assemble {
        copy {
            from("src/main/resources")
            into("build/js/packages/shared/kotlin/resources")
        }
        finalizedBy("deletePackages")
    }
}
