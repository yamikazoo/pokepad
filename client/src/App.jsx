import { useState } from 'react';
import Archive from './components/Archive';
import './App.css';

function App() {
  const [view, setView] = useState('home'); // Options: 'home', 'archive', 'collections'

  return (
    <div className="app">
      <header>
        <h1>PokePad 1.0</h1>
      </header>

      <main>
        {/* VIEW 1: LANDING PAGE */}
        {view === 'home' && (
          <div className="landing-menu">
            <p>Welcome to your Card Manager.</p>
            <div className="button-group">
              <button onClick={() => setView('archive')}>
                View Archive (Public)
              </button>
              <button onClick={() => setView('collections')} disabled>
                My Collections (Coming Soon)
              </button>
            </div>
          </div>
        )}

        {/* VIEW 2: ARCHIVE */}
        {view === 'archive' && (
          <Archive onBack={() => setView('home')} />
        )}

        {/* VIEW 3: COLLECTIONS (Placeholder) */}
        {view === 'collections' && (
          <div>
            <button onClick={() => setView('home')}>Back</button>
            <h2>Collections Coming Soon!</h2>
          </div>
        )}
      </main>
    </div>
  );
}

export default App;