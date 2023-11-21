// eslint-disable-next-line no-unused-vars
import React, { useState } from 'react';
import './login.css';
import { Link } from 'react-router-dom';


export default function Login01() {
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');

    const handleInputChange = (event) => {
        const { name, value } = event.target;
        if (name === 'email') setEmail(value);
        else if (name === 'password') setPassword(value);
    };

    const handleSubmit = (event) => {
        event.preventDefault(); // Isso impede o comportamento padrão do formulário de recarregar a página.
        console.log('Login submitted:', { email, password });
    };

    const mensagemtemporaria = () => {
        alert('Carregando...');
    };

    return (
        <div className="container">
            <div className="left-side">
                {/* Conteúdo do lado esquerdo (se necessário) pode ser adicionado aqui */}
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
                                value={password}
                                onChange={handleInputChange}
                                required
                            />
                        </div>
                        <div className="button-group">
                            <Link to="/telahome">
                                <button type="submit">ENTRAR</button>
                            </Link>
                            <button type="button" onClick={mensagemtemporaria}>CADASTRAR-SE</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
}