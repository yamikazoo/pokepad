import { useState, useEffect } from 'react';

// archive component. when clicked fetches cards from backend and displays them
function Archive({ onBack }) {
    const [cards, setCards] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // This is the "Bridge" to your Java Backend
    useEffect(() => {
        fetch('http://localhost:8080/api/cards')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => {
                setCards(data);
                setLoading(false);
            })
            .catch(err => {
                console.error("Fetch error:", err);
                setError(err.message);
                setLoading(false);
            });
    }, []);

    return (
        <div className="archive-container">
            <button className="back-btn" onClick={onBack}>← Back to Home</button>
            <h2>Card Archive</h2>

            {loading && <p>Loading cards from the Vault...</p>}
            {error && <p style={{color: 'red'}}>Error: Is your Spring Boot Backend running?</p>}

            <div className="card-grid">
                {cards.map(card => (
                    <div key={card.id} className="card-item">
                        {/* We use the image URL from your DataSeeder */}
                        <img src={card.imageUrl} alt={card.name} />
                        <h3>{card.name}</h3>
                        <p>{card.rarity}</p>
                    </div>
                ))}
            </div>
        </div>
    );
}

export default Archive;