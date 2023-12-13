import './study.css';
import { Link } from 'react-router-dom';
import Popup from './popupstudyspace.jsx';
import { useState, useEffect } from 'react';
import api from '../../services/api';
import { useNavigate } from 'react-router-dom';
import PopupQuiz from './PopupQuiz';
const Studyspace = () => {

    const [showQuizPopup, setShowQuizPopup] = useState(false);
    const [flashcards, setFlashCards] = useState([]);
    const [flashcardPopup, setFlashcardPopup] = useState(null);

    const getFlashCards = async () => {
        try {

            const uid = sessionStorage.getItem("uid");
            console.log(uid);
            if (uid == null) window.location.href = "/login";

            /* 
            const resCategoriesIds = await api.get(`/category/${uid}`);

            const categoriesIds=[];
            for (const category of resCategoriesIds.data) categoriesIds.push(category.id)

            const flashcardsArray = []
            for (const id of categoriesIds) {
                let res = await api.get(`/flashcard/${id}`);
                for (const flashcard of res.data) flashcardsArray.push(flashcard)
            } 
            setFlashCards(flashcardsArray);
            */

            const response = await api.get(`/flashcard`);
            console.log("flashcardsss", response.data);
            setFlashCards(response.data);
        } catch (error) {
            console.log(error);
        }
    }

    useEffect(() => {
        getFlashCards();
    }, []);

    const [showPopup, setShowPopup] = useState(false);
    const [categoryName, setCategoryName] = useState('');

    const handleCreateCategory = async () => {
        try {
            const uid = sessionStorage.getItem("uid");
            console.log(uid);
            console.log(categoryName);
            if (uid == null) window.location.href = "/login";
            const response = await api.post(`/category/${uid}`, { name: categoryName });
            setCategoriesList([...categoriesList, response.data]);
        } catch (error) {
            console.log(error);
        }
    }

    const [categoriesList, setCategoriesList] = useState([]);

    const getCategories = async () => {
        try {
            const uid = sessionStorage.getItem("uid");
            console.log(uid);
            if (uid == null) window.location.href = "/login";
            const response = await api.get(`/category/${uid}`);
            console.log(response.data);
            setCategoriesList(response.data);
        } catch (error) {
            console.log(error);
        }

    }

    useEffect(() => {
        getCategories();
    }, [])

    const navigate = useNavigate();
    return (
        <div className='all'>
            <div className="conteudopag">
                <div className="flashcards-content">
                    <div className='header'>Seus Flashcards</div>
                    <div className='temas'>Temas</div>

                    <div style={{
                        display: 'flex',
                        flexDirection: 'row',
                        justifyContent: 'space-between',
                        alignItems: 'center',
                        width: '100%',
                        gap: '10px',
                        flexWrap: 'wrap',
                    }}>
                        {categoriesList.length > 0 &&
                            categoriesList.map((category, index) =>
                            (
                                <div index={index} className='card-conteudo' onClick={() => {
                                    navigate(`/flashCard/${category.name}/${category.id}`)
                                }}>
                                    <div className='card1'>
                                        <h3>{category.name}</h3>
                                    </div>
                                </div>
                            ))}
                    </div>


                    <div className="button-add-category">
                        <button onClick={() => setShowPopup(true)}>Adicionar Categoria</button>
                    </div>

                    {showPopup && (
                        <Popup
                            categoryName={categoryName}
                            setCategoryName={setCategoryName}
                            onSave={handleCreateCategory}
                        />
                    )}
                    {
                        showQuizPopup && (
                            <PopupQuiz
                                open={true}
                                handleClose={() => setShowQuizPopup(false)}
                                flashcard={flashcardPopup}
                            />
                        )
                    }
                </div>
                <div className='tudoquizzes'>
                    <div className='quizzestitulo'>Quizzes</div>
                    <div className="quizzes-tests-wrapper" style={{
                        overflowX: "scroll"
                    }}>
                        {
                            flashcards.length > 0 &&
                            flashcards.map((flashcard, index) => (
                                <div className="quizz-card" index={index}>
                                    <div className="quizz-icon">?</div>
                                    <div className="quizz-details">
                                        <div className="quizz-question">{flashcard.question}</div>
                                        {/* <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</p> */}                                <button
                                            onClick={() => {
                                                setShowQuizPopup(true);
                                                setFlashcardPopup(flashcard);
                                            }}
                                        >FAZER QUIZZ</button>
                                    </div>
                                </div>
                            ))
                        }

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