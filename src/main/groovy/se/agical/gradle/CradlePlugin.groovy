package se.agical.gradle

import org.gradle.api.*

class CradlePlugin implements Plugin<Project> {

	def void apply(Project project) {
		project.task('swank') {
			description = 'Starts Clojures version of Swank.'
			doLast {
			        sourcepath = project.sourceSets*.clojure.srcDirs
				sourcepath = project.files(sourcepath.flatten())
				execpath = sourcepath + project.configurations.runtime + project.configurations.testCompile

				project.javaexec {
					main = 'clojure.main'
					classpath = execpath
					args = ["-e", "(use 'swank.swank)(apply -main *command-line-args*)"]
				}
			}
       		}
	}

}
