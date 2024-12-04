Resumo dos Passos
Instalar o git-filter-repo: pip install git-filter-repo
Clonar o repositório limpo: git clone https://github.com/seu-usuario/seu-repositorio.git CarroAuth-clean
Remover o arquivo do histórico: git filter-repo --path src/main/resources/application.properties --invert-paths
Verificar se o arquivo foi removido: git log --all -- src/main/resources/application.properties
Adicionar o arquivo ao .gitignore: src/main/resources/application.properties
Forçar o push para o repositório remoto: git push origin --force
