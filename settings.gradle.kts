/*******************************************************************************
 * Copyright (c) 2024 Bayerische Motoren Werke Aktiengesellschaft (BMW AG)
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Apache License, Version 2.0 which is available at
 * https://www.apache.org/licenses/LICENSE-2.0.
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 ******************************************************************************/

rootProject.name = "tractusx-edc-compatability-tests"

// this is needed to have access to snapshot builds of plugins
pluginManagement {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        mavenCentral()
    }
    versionCatalogs {
        create("stableLibs") {
            from(files("./gradle/libs.stable.versions.toml"))
        }
        create("libs076") {
            from(files("./gradle/libs.0.7.6.versions.toml"))
        }
    }
}

// add dependencies
include(":runtimes:snapshot:identityhub-snapshot")
include(":runtimes:snapshot:controlplane-snapshot")
include(":runtimes:snapshot:dataplane-snapshot")
include(":runtimes:stable:controlplane-stable")
include(":runtimes:stable:dataplane-stable")
include(":runtimes:stable:extensions")
include(":runtimes:076:controlplane-076")
include(":runtimes:076:dataplane-076")
include(":runtimes:076:stable:extensions-076")
include(":tests:compatibility-tests")
