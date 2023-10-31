export default function Config(){
    return(
        <div className="all">
        <section className="containers">
            <div className="container1">
                <div className="configuracoes">
                    <h1>Configurações</h1>
                </div>
                <div className="ap">
                <div className="aparencia">
                    <h1>Aparência</h1>
                    <p>Permite aos usuários personalizar a interface do app de acordo com suas preferências visuais. Isso pode incluir a escolha entre um modo claro e escuro, alterar o esquema de cores ou ajustar o tamanho e o estilo da fonte para uma leitura mais confortável.</p>
                </div>
                    <div className="modos">
                    <label for="modo_de_cor"></label>
        <select id="modo_de_cor" name="modo_de_cor">
            <option value="Escuro">Escuro</option>
            <option value="Claro">Claro</option>
                </select>
                    </div>
                </div>
                <div className="ap">
                <div className="notificacoes">
                    <h1>Ativar notificações</h1>
                    <p>Dá aos usuários a opção de receber notificações em tempo real sobre atualizações, novos conteúdos, lembretes ou qualquer outro alerta relevante do app. Ao ativar essa funcionalidade, o usuário pode se manter informado e engajado com o conteúdo e as atividades propostas.</p>    
                </div>
                <div className="modos">
                <label for="modo"></label>
        <select id="modo" name="modo">
            <option value="Ativado">Ativado</option>
            <option value="Desativado">Desativado</option>
                </select>
                    </div>
                </div>
                <div className="ap">
                <div className="linguagem">
                    <h1>Linguagem</h1>
                    <p>Permite que os usuários selecionem o idioma de sua preferência para a interface e o conteúdo do app. Isso garante que o usuário tenha uma experiência mais personalizada e compreensível, especialmente em um contexto global onde os usuários podem vir de diferentes regiões linguísticas.</p>
                </div>
                <div className="modos">
                <label for="Lingua"></label>
        <select id="Lingua" name="Lingua">
            <option value="Português - Brasil">Português - Brasil</option>
            <option value="Ingles - EUA">Ingles - EUA</option>
                </select>
                    </div>
                </div>
                <div className="ap">
                <div className="mestudo">
                    <h1>Modo de estudo</h1>
                    <p>Esta funcionalidade pode oferecer aos usuários opções de modos de estudo:</p>
                    <h2>Foco Intenso:</h2>
                    <p>Este modo é projetado para aqueles que desejam mergulhar profundamente em seus estudos. Ao minimizar distrações e notificações, ele cria um ambiente propício para a concentração. Os conteúdos fornecidos são mais extensos e complexos, permitindo que o usuário explore os tópicos em detalhes. É ideal para sessões de estudo prolongadas onde o objetivo é compreender e assimilar informações intrincadas.</p>
                    <h2>Rapidez:</h2>
                    <p>Desenvolvido para quem está sempre em movimento, este modo foca em revisões curtas e frequentes. Com conteúdos mais diretos e concisos, permite que os usuários absorvam informações essenciais em pouco tempo. É perfeito para pessoas que têm agendas lotadas e precisam otimizar seu tempo de estudo, guardando energia mental.</p>
                </div>
                <div className="modos">
                <label for="Foco"></label>
        <select id="Foco" name="Foco">
            <option value="Foco moderado">Foco moderado</option>
            <option value="Foco intenso">Foco intenso</option>
                </select>
                    </div>
                </div>
            </div>
            <div className="container2">
                <div className="ajuda">
                    <h3>Ajuda</h3>
                </div>
                <div className="chat">
                    <h4>Chat</h4>
                </div>
                <hr />
                <div className="duvidas">
                    <h4>Dúvidas frequentes</h4>
                </div>
            </div>
        </section>
            <footer className="footer">
            <div className="imgesquerda"> 
        <div><a href="">
            <img className="img" src="icone.config.PNG" alt="" />
        </a></div>
        <div><a href="">
            <img className="img" src="icone.perfil.png" alt="" />
        </a></div>
        <div><a href="">
            <img className="img" src="icone.lua.png" alt="" />
        </a></div>
        </div>
        <div className="imgcenter">
            <div><a href="">
            <img className="img" src="icone.doc.png" alt="" />
        </a></div>
            <div><a href="">
            <img className="img" src="icone.lista.png" alt="" />
        </a></div>
            <div><a href="">
            <img className="img" src="icone.trevo.png" alt="" />
        </a></div>
            <div><a href="">
            <img className="img" src="icone.bandeira.png" alt="" />
        </a></div>
        </div>
        <div className="imgdireita">
        <a href="">
            <img className="img" src="icone.wp.png" alt="" />
        </a>
        </div>
            </footer>
        </div>
    )
}