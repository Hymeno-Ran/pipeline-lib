void call() {
    echo "✅ Running pre-build checks..."
    stage('Pre-Build Checks') {
        checkout scm
    }
}
