pipeline{

    agent any

//     environment {
//     }

    stages {

        stage ('Compile Stage') {

            steps {
                withMaven() {
                    sh 'mvn clean install'
                }
            }
        }
    stage ('Test Stage') {
            steps {
                withMaven() {
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