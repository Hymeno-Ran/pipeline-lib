void call() {
    echo "✅ Running pre-build checks..."
    stage('Pre-Build Checks') {
        if (config.git_url) {
            // Job Pipeline thường: không có biến scm -> lấy repo từ config
            git url: config.git_url, branch: config.git_branch ?: 'main'
        } else {
            // Multibranch Pipeline: dùng chính repo/branch đang build
            checkout scm
        }
    }
}
