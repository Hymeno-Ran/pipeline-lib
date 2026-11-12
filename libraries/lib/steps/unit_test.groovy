void call() {
    stage('Unit test') {
        def pyVersion = config.python_version ?: '3.12'
        def reqs      = config.requirements ?: 'requirements.txt'

        docker.image("python:${pyVersion}-slim").inside {
            try {
                sh """
                    python -m venv .venv
                    . .venv/bin/activate
                    pip install -q -r ${reqs}
                    python -m pytest -q --junitxml=reports/junit.xml
                """
            } finally {
                junit allowEmptyResults: true, testResults: 'reports/junit.xml'
            }
        }
    }
}
