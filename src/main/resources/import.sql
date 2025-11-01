-- 1. Popula a tabela de consultores
INSERT INTO public.consultores (cargo, gt, nome, username) VALUES
('Desenvolvedor Pleno', 'GT-Finanças', 'Ana Silva', 'ana.silva'),
('Desenvolvedor Júnior', 'GT-Saúde', 'Bruno Costa', 'bruno.costa'),
('Arquiteto de Soluções', 'GT-Finanças', 'Carla Dias', 'carla.dias'),
('Desenvolvedor Sênior', 'GT-Comércio', 'Daniel Moreira', 'daniel.moreira'),
('Analista de QA', 'GT-Saúde', 'Elisa Fernandes', 'elisa.fernandes');

-- 2. Popula a tabela de demandas, usando os IDs dos consultores (1-5)
INSERT INTO public.demandas (consultor_id, data_criacao, descricao, status) VALUES
(1, NOW(), 'Criar novo endpoint de relatório financeiro', 'Em Andamento'),
(2, '2025-10-28 14:30:00', 'Corrigir bug visual na tela de login', 'Aberta'),
(1, '2025-10-27 09:15:00', 'Atualizar documentação da API de pagamentos', 'Concluída'),
(3, '2025-10-29 11:00:00', 'Desenhar arquitetura do novo microsserviço de notificações', 'Em Andamento'),
(4, '2025-10-30 16:00:00', 'Desenvolver funcionalidade de upload de arquivos', 'Aberta'),
(5, '2025-10-31 10:45:00', 'Criar plano de testes para o módulo de checkout', 'Bloqueada'),
(2, NOW(), 'Revisar PR #123 - Correção de typo', 'Concluída');