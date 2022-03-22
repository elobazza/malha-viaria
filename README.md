# Malha Viária 🚦

Projeto desenvolvido na disciplina de Desenvolvimento de Sistemas Paralelos e Distribuídos, da sexta fase do curso de Engenharia de Software!

**Objetivo Geral 🎯**

Desenvolver um simulador de tráfego, onde existirão veículos que se movem pelas vias de uma malha viária, que será informada através de um arquivo.

**Requisitos do Projeto 📜**

- Cada veículo deve ser um thread
- O veículo se movimenta pela malha, uma posição por vez, respeitando o sentido de fluxo da pista. O veículo só pode se mover caso a posição à frente esteja livre.
- O veículo pode trocar de pista, no caso de vias de pista dupla. Para trocar de pista, o veículo se move para a posição em diagonal à frente, mas somente se ela estiver livre
- Ao se deparar com um cruzamento deve escolher, aleatoriamente, uma das vias de saída do cruzamento para seguir viagem. A escolha deve ser feita antes do veículo ingressar no cruzamento
- Só deve se mover pelo cruzamento se todas as posições por onde vai passar estiverem totalmente livres (exclusão mútua)
- Não deve bloquear o cruzamento de outros veículos (ficar parado no cruzamento)
- Novos veículos são inseridos nos pontos de entrada da malha 
- Ao atingir um ponto de saída, o veículo deve ser encerrado
- Veículos possuem velocidades de movimentação diferente
- Deve possuir opções para limitar quantidade de veículos
- Ao iniciar simulação, fica inserindo veículos, que se movimentam na malha, respeitando a quantidade descrita no item anterior
- Ao encerrar simulação, para de inserir veículos e encerra imediatamente todos os veículos.

Integrantes: Eloísa Bazzanella e Maria Eduarda Buzana 👭
