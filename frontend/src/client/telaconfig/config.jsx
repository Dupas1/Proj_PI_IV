import { Link } from 'react-router-dom';

export default function Config() {
    return (
        <div className="allc">
            <section className="containersc">
                <div className="container1c">
                    <div className="configuracoesc">
                        <h1>Configurações</h1>
                    </div>
                    <div className="apc">
                        <div className="aparenciac">
                            <h1>Aparência</h1>
                            <p className="pc">Permite aos usuários personalizar a interface do app de acordo com suas preferências visuais. Isso pode incluir a escolha entre um modo claro e escuro, alterar o esquema de cores ou ajustar o tamanho e o estilo da fonte para uma leitura mais confortável.</p>
                        </div>
                        <div className="modosc">
                            <label for="modo_de_corc"></label>
                            <select id="modo_de_corc" name="modo_de_cor">
                                <option value="Escuro">Escuro</option>
                                <option value="Claro">Claro</option>
                            </select>
                        </div>
                    </div>
                    <div className="apc">
                        <div className="notificacoesc">
                            <h1>Ativar notificações</h1>
                            <p className="pc">Dá aos usuários a opção de receber notificações em tempo real sobre atualizações, novos conteúdos, lembretes ou qualquer outro alerta relevante do app. Ao ativar essa funcionalidade, o usuário pode se manter informado e engajado com o conteúdo e as atividades propostas.</p>
                        </div>
                        <div className="modosc">
                            <label for="modoc"></label>
                            <select id="modoc" name="modo">
                                <option value="Ativado">Ativado</option>
                                <option value="Desativado">Desativado</option>
                            </select>
                        </div>
                    </div>
                    <div className="apc">
                        <div className="linguagemc">
                            <h1>Linguagem</h1>
                            <p className="pc">Permite que os usuários selecionem o idioma de sua preferência para a interface e o conteúdo do app. Isso garante que o usuário tenha uma experiência mais personalizada e compreensível, especialmente em um contexto global onde os usuários podem vir de diferentes regiões linguísticas.</p>
                        </div>
                        <div className="modosc">
                            <label for="Linguac"></label>
                            <select id="Linguac" name="Lingua">
                                <option value="Português - Brasil">Português - Brasil</option>
                                <option value="Ingles - EUA">Ingles - EUA</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div className="container2c">
                    <div className="ajudac">
                        <h3>Ajuda</h3>
                    </div>
                    <div className="chatc">
                        <h4>Chat</h4>
                    </div>
                    <hr />
                    <div className="duvidasc">
                        <h4>Dúvidas frequentes</h4>
                    </div>
                </div>
            </section>
            <footer className="footer">
                <div className="imgesquerda">
                    <div>
                        <Link to="/telaconfig">
                            <img className="img" src="icone.config.png" alt="" />
                        </Link>
                    </div>
                    <div>
                        <Link to="/profile">
                            <img className="img" src="icone.perfil.png" alt="" />
                        </Link>
                    </div>
                    <div>
                        <a href="">
                            <img className="img" src="icone.lua.png" alt="" />
                        </a>
                    </div>
                </div>
                <div className="imgcenter">
                    <div>
                        <Link to="/studyspace">
                            <img className="img" src="icone.doc.png" alt="" />
                        </Link>
                    </div>
                    <div>
                        <Link to="/flashCard">
                            <img className="img" src="icone.lista.png" alt="" />
                        </Link>
                    </div>
                    <div>
                        <a href="">
                            <img className="img" src="icone.trevo.png" alt="" />
                        </a>
                    </div>
                    <div>
                        <a href="">
                            <img className="img" src="icone.bandeira.png" alt="" />
                        </a>
                    </div>
                </div>
                <div className="imgdireita">
                    <a href="">
                        <Link to="/telahome">
                            <img className="img" src="icone.wp.png" alt="" />
                        </Link>
                    </a>
                </div>
            </footer>
        </div>
    )
}