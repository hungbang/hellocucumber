pipeline{

    agent any
//     environment {
//     }

    tools {
        jdk 'java-1.8.0-openjdk'
        maven 'maven-3.8.6'
    }

    stages {
        stage ('Initialize') {
                    steps {
                        sh '''
                            echo "PATH = ${PATH}"
                            echo "M2_HOME = ${M2_HOME}"
                        '''
                    }
                }
        stage ('Compile Stage') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage ('Test Stage') {
            steps {
                sh 'mvn test'
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