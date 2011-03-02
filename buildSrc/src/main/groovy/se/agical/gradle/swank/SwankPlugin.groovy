package se.agical.gradle.swank

import org.gradle.api.*

class SwankPlugin implements Plugin<Project> {

	def void apply(Project project) {
		project.task('swank') {
			description = 'Starts Clojures version of Swank.'
			doLast {
				execpath = project.configurations.runtime + project.configurations.compile + project.configurations.testCompile
				project.javaexec {
					main = 'clojure.main'
					classpath = execpath
					args = ["-e", "(use 'swank.swank)(apply -main *command-line-args*)"]
				}
			}
       		}
	}

}
