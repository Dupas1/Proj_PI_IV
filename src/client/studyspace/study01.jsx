import './study.css'; 

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
                        <div className="teste-name">Teste de MongoDB - Difícil</div>
                        <div className="teste-duration">Aproximadamente 1h</div>
                    </div>

                    <div className="teste-card">
                        <div className="teste-name">Teste de Cálculo - Fácil</div>
                        <div className="teste-duration">Aproximadamente 15 min</div>
                    </div>

                    <div className="teste-card">
                        <div className="teste-name">Teste de Java - Médio</div>
                        <div className="teste-duration">Aproximadamente 30 min</div>
                    </div>
                </div>
            
        </div>
    </div>
    );
}

export default Studyspace;
