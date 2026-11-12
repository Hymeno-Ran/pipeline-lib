void call() {
    stage('Smoke test') {
        retry(10) {
            sleep 3
            sh "curl -fsS ${config.health_url}"
        }
    }
}
