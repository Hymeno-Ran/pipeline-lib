void call() {
    stage('Deploy') {
        withCredentials([file(credentialsId: config.env_credentials_id, variable: 'APP_ENV_FILE')]) {
            try {
                sh 'cp "$APP_ENV_FILE" .env'
                sh """
                    REGISTRY=${config.registry} IMAGE_TAG=${env.BUILD_NUMBER} \
                    docker compose -p ${config.image} \
                      -f ${config.compose_file ?: 'docker-compose.yaml'} \
                      -f ${config.compose_override} \
                      up -d --no-build --wait
                """
            } finally {
                sh 'rm -f .env'   // không để secret nằm lại trong workspace
            }
        }
    }
}
