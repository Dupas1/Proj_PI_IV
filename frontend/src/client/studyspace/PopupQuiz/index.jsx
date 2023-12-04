import { useState } from "react";
import api from "../../../services/api";
const PopupQuiz = ({ open, handleClose, flashcard }) => {
  const [showAnswer, setShowAnswer] = useState(false);
  const [dificuldade, setDificuldade] = useState("easy");

  const handleChange = (e) => {
    setDificuldade(e.target.value);
    updateDificuldade();
  };

  const updateDificuldade = async () => {
    try {
        const response = await api.put(`/flashcards/${flashcard.id}`, {dificuldade});
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
                <option value="easy">Fácil</option>
                <option value="medium">Médio</option>
                <option value="hard">Difícil</option>
            </select>
            <button onClick={handleClose}>Fechar</button>
        </div>
        </div>
      )}
    </div>
  );
};

export default PopupQuiz;
