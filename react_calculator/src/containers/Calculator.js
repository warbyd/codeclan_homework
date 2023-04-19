import React, { useState } from 'react';
import KeyPad from '../components/KeyPad';
import '../App.css';

function App() {

  const [previousTotal, setPreviousTotal] = useState(0);
  const [runningTotal, setRunningTotal] = useState(0);
  const [previousOperator, setPreviousOperator] = useState(null);
  const [newTotal, setNewTotal] = useState(true);
  const [calculatedTotal, setCalculatedTotal] = useState(0);


  const numberClick = (number) => {
    let tempTotal = runningTotal;
    if (runningTotal === 0 || newTotal) {
      if (calculatedTotal) {
        setPreviousTotal(calculatedTotal);
      } else {
        setPreviousTotal(runningTotal);
      }
      tempTotal = 0;
      setNewTotal(false);
    }
    setRunningTotal(parseFloat("" + tempTotal + number));
  }

  const handleDecimal = () => {
    if (!runningTotal.toString().includes(".")) {
      setRunningTotal(runningTotal + ".");
    }
  }

  const clearClick = () => {
    if (runningTotal === 0) {
      setPreviousOperator(null);
      setPreviousTotal(null);
      setCalculatedTotal(0);
    }
    setRunningTotal(0);
  }

  const operatorClick = (operator) => {
    if (previousTotal && previousOperator) {
      switch (previousOperator) {
        case "+":
          add(runningTotal);
          break;
        case "-":
          subtract(runningTotal);
          break;
        case "*":
          multiply(runningTotal);
          break;
        case "/":
          if (runningTotal === 0) {
            return ('Error');
          } else {
            divide(runningTotal);
          }
          break;
        default:
          break;
      }
    }
    if (operator === "=") {
      setPreviousOperator(null);
    } else {
      setPreviousOperator(operator);
    }
    setPreviousTotal(runningTotal);
    setNewTotal(true);
  }

  const add = (number) => {
    let calculatedNumber = parseFloat(previousTotal) + parseFloat(number);
    setRunningTotal(calculatedNumber);
    setCalculatedTotal(calculatedNumber);
  }

  const subtract = (number) => {
    let calculatedNumber = parseFloat(previousTotal) - parseFloat(number);
    setRunningTotal(calculatedNumber);
    setCalculatedTotal(calculatedNumber);
  }

  const multiply = (number) => {
    let calculatedNumber = parseFloat(previousTotal) * parseFloat(number);
    setRunningTotal(calculatedNumber);
    setCalculatedTotal(calculatedNumber);
  }

  const divide = (number) => {
    let calculatedNumber = parseFloat(previousTotal) / parseFloat(number);
    if (parseFloat(number) === 0) {
      setRunningTotal('Error');
      setCalculatedTotal('Error');
      return 'Error';
    } else {
      setRunningTotal(calculatedNumber);
      setCalculatedTotal(calculatedNumber);
    }
  };
  
  



  return (
    <div className="container">
      <div className="calculator">
        <div data-testid="running-total" id="running-total" className="display">{runningTotal}</div>
        <KeyPad
          handleNumber={numberClick}
          handleOperator={operatorClick}
          handleClear={clearClick}
          handleDecimal={handleDecimal}
        />
      </div>
    </div>
  );
}

export default App;
