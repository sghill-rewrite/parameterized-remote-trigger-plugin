// Builds a module using https://github.com/jenkins-infra/pipeline-library
// Requirements:
//   - agents with label 'linux' and 'windows'
//   - tools with label 'jdk8' and 'mvn'
//   - latest Pipeline plugins, 'Timestamper' plugin
//   - recommended to use this Jenkinsfile with 'Multibranch Pipeline' plugin

buildPlugin(useContainerAgent: true, configurations: [
  [platform: 'linux', jdk: 21],
  [platform: 'windows', jdk: 17],
])
