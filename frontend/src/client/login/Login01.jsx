// eslint-disable-next-line no-unused-vars
import React, { useState } from 'react';
import './login.css';
import { Link, useNavigate } from 'react-router-dom';
import api from '../../services/api'



export default function Login01() {
    const [email, setEmail] = useState('');
    const [psw, setPassword] = useState('');

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        if (name === 'email') setEmail(value);
        else if (name === 'password') setPassword(value);
    };

    
    const navigate = useNavigate();

    const handleSubmit = async (event) => {
        event.preventDefault();
        const url = `/login/${email}`;
        console.log(`Making a POST request to: ${api.defaults.baseURL}${url}`);
        console.log(` ${email}, ${psw}`)
        try {
            const response = await api.post(url,{ name, gender, email, psw, phone });
            console.log("response",response);
                window.alert("Usuário Entrando...");
                navigate("/");
            }catch(error){
            window.alert("Erro ao entrar usuário");
            console.error("Error message",error.message);
            console.error("Error response", error.response);
        }
    };

    return (
        <div className="container">
            <div className="left-side">
            </div>
            <div className="right-side">
                <img src="https://cdn.discordapp.com/attachments/1097641912598540363/1151599588340408412/image.png?ex=65679031&is=65551b31&hm=90b0dbd2b66b2fcb33bc628ddf934682f4c374ed8fc7ba416038cee8745f4fa6&" alt="Woodpeacker Logo" className="logo" />
                <p className="greeting-1">OLÁ USUÁRIO!</p>
                <p className="greeting-2">Eu sou seu assistente inteligente para cuidar da sua memória</p>
                <div className="login-form">
                    <form onSubmit={handleSubmit}>
                        <div className="form-group">
                            <input
                                type="text"
                                name="email"
                                placeholder="Email"
                                value={email}
                                onChange={handleInputChange}
                                required
                            />
                        </div>
                        <div className="form-group">
                            <input
                                type="password"
                                name="password"
                                placeholder="Senha"
                                value={psw}
                                onChange={handleInputChange}
                                required
                            />
                        </div>
                        <div className="button-group">
                            <Link to="/telahome">
                                <button type="submit">ENTRAR</button>
                            </Link>
                            <Link to ="/cadastropage">
                            <button type="button">CADASTRAR-SE</button>
                            </Link>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}