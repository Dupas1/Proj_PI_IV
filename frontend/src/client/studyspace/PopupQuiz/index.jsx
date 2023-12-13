import { useState } from "react";
import api from "../../../services/api";
const PopupQuiz = ({ open, handleClose, flashcard }) => {
  const [showAnswer, setShowAnswer] = useState(false);
  const [dificuldade, setDificuldade] = useState("EASY");


  const handleChange = (e) => {
    setDificuldade(e.target.value);
    updateDificuldade();
  };

  const updateDificuldade = async () => {
    try {
      const categoryID = sessionStorage.getItem("uid");
      console.log(categoryID);
      
        const url = `/flascard/review/${flashcard.id}`;
        const timeSkip = new Date().toISOString();
        const response = await api.put(url, {timeSkip, question:flashcard.question, difficulty:dificuldade, answer:flashcard.answer, categoryID });
        console.log(response);
    } catch (error) {
        console.log(error);
    }
  }

  return (
    <div>
      {open && (
        <div
          style={{
            position: "fixed",
            top: "50%",
            left: "50%",
            transform: "translate(-50%, -50%)",
            width: "400px",
            height: "auto",
            backgroundColor: "#333",
            padding: "20px",
            borderColor: "#ccc",
            borderWidth: "1px",
            borderStyle: "solid",
            zIndex: 100,
            borderRadius: "10px",
          }}
        >
          <div style={{
            height: "100%",
            display: "flex",
            flexDirection: "column",
            gap: "10px",
          }}>
            <h1 
                style={{
                    color: "#fff",
                    fontSize: "22px",
                    textAlign: "center",
                    marginBottom: "10px",
                    textTransform: "capitalize"
                }}
            >{flashcard.question}</h1>
            {showAnswer && <p
            
            style={{
                color: "#fff",
                fontSize: "18px",
                textAlign: "center",
                marginBottom: "10px",
                textTransform: "capitalize"
            }}
            >{flashcard.answer}</p>}
            <button 
          
            onClick={() => setShowAnswer(!showAnswer)}>
              {showAnswer ? "Ocultar resposta" : "Mostrar resposta"}
            </button>
          </div>
          <div
          style={{height: "100%", width: "100%", display: "flex", flexDirection: "column", gap: "10px"}}
          >
            <select
                name="dificuldade"
                id="dificuldade"
                value={dificuldade}
                onChange={handleChange}
                style={{
                    padding: "10px",
                    marginTop: "10px",
                    borderRadius: "5px",
                    border: "none",
                    cursor: "pointer"
                }}
            >
                <option value="EASY">Fácil</option>
                <option value="MEDIUM">Médio</option>
                <option value="HARD">Difícil</option>
            </select>
            <button onClick={handleClose}>Fechar</button>
        </div>
        </div>
      )}
    </div>
  );
};

export default PopupQuiz;
