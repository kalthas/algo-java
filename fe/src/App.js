import React, { Component } from 'react';
import './App.css';
import TreeView from "./components/TreeView";

class App extends Component {
  render() {
    return (
      <div className="App">
          <div style={{
              width: '100vw',
              height: '99vh'
          }}>
            <TreeView />
          </div>
      </div>
    );
  }
}

export default App;
