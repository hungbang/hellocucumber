pipeline{

    agent any

    environment {
    }

    stages {

        stage ('Compile Stage') {

            steps {
                withMaven(maven: 'maven_3_5_0') {
                    sh 'mvn clean install'
                }
            }
        }
    stage ('Test Stage') {
            steps {
                withMaven(maven: 'maven_3_5_0') {
                    sh 'mvn test'
                }
            }
        }


        stage ('Cucumber Reports') {

            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'
            }

        }

    }

    post {
        always {
            publishHTML (target: [
            reportDir: 'test-output/extent-reports', reportFiles: '*.html', reportLink: 'Extent Reports'
            ])
        }
    }

}