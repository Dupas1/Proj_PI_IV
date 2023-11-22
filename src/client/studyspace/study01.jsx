import './study.css';
import { Link } from 'react-router-dom';

const Studyspace = () => {
    return (
        <div className='all'>
            <div className="conteudopag">
                <div className="flashcards-content">
                    <div className='header'>Seus Flashcards</div>
                    <div className='temas'>Temas</div>

                    <div className='card-conteudo'>
                        <div className='card1'>
                            <h3>Mongo Db</h3>
                            <p>Nível de prioridade III</p>
                            <p>20 Itens</p>
                        </div>

                        <div className='card2'>
                            <h3>Java</h3>
                            <p>Nível de prioridade II</p>
                            <p>10 Itens</p>
                        </div>

                        <div className='card3'>
                            <h3>Calculo</h3>
                            <p>Nível de prioridade III</p>
                            <p>25 Itens</p>
                        </div>
                    </div>
                </div>

                <div className='tudoquizzes'>
                    <div className='quizzestitulo'>Quizzes</div>
                    <div className="quizzes-tests-wrapper">

                        <div className="quizz-card">
                            <div className="quizz-icon">?</div>
                            <div className="quizz-details">
                                <div className="quizz-question">What is Lorem Ipsum?</div>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                <button>FAZER QUIZZ</button>
                            </div>
                        </div>

                        <div className="quizz-card">
                            <div className="quizz-icon">?</div>
                            <div className="quizz-details">
                                <div className="quizz-question">Where does it come from?</div>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                <button>FAZER QUIZZ</button>
                            </div>

                        </div>

                        <div className="quizz-card">
                            <div className="quizz-icon">?</div>
                            <div className="quizz-details">
                                <div className="quizz-question">Where does it come from?</div>
                                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p>
                                <button>FAZER QUIZZ</button>
                            </div>
                        </div>
                    </div>


                </div>

                <div className="testes-content">
                    <div className='testes-titulo'>Testes</div>

                    <div className="teste-card">
                        <div className="teste-name">
                            <img className='bolinhaimg' src='/public/bolinhaverde.png'>
                            </img>
                            Teste de MongoDB - Difícil
                            <div className="teste-duration">Aproximadamente 1h</div>
                        </div>
                    </div>

                    <br></br>
                    <div className="teste-card">
                        <div className="teste-name">
                            <img className='bolinhaimg' src='/public/bolinhaverde.png'>
                            </img>Teste de Cálculo - Fácil
                            <div className="teste-duration">Aproximadamente 15 min</div>
                        </div>
                    </div>
                    <br></br>

                    <div className="teste-card">
                        <div className="teste-name">
                            <img className='bolinhaimg' src='/public/bolinhaverde.png'>
                            </img>
                            Teste de Java - Médio
                            <div className="teste-duration">Aproximadamente 30 min</div>
                        </div>
                    </div>
                </div>

            </div>

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
    );
}

export default Studyspace;