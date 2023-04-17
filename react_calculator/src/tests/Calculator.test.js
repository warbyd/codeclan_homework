import React from 'react';
import Calculator from '../containers/Calculator';
import {render, fireEvent} from '@testing-library/react';

describe('Calculator', () => {
  let container;
  beforeEach(() => {
    container = render(<Calculator/>)
  })

  it('should change running total on number enter', () => {
    const button4 = container.getByTestId('number4');
    const runningTotal = container.getByTestId('running-total');
    fireEvent.click(button4);
    expect(runningTotal.textContent).toEqual('4');
  })

  it('1 + 4 should equal 5', () => {
    const button1 = container.getByTestId('number1');
    const addButton = container.getByTestId('operator-add');
    const button4 = container.getByTestId('number4');
    const equalsButton = container.getByTestId('operator-equals');
    const runningTotal = container.getByTestId('running-total');
    fireEvent.click(button1);
    fireEvent.click(addButton);
    fireEvent.click(button4);
    fireEvent.click(equalsButton);
    expect(runningTotal.textContent).toEqual('5');
  });

  it('7 - 4 should equal 3', () => {
    const button7 = container.getByTestId('number7')
    const minusButton = container.getByTestId('operator-subtract')
    const button4 = container.getByTestId('number4')
    const equalsButton = container.getByTestId('operator-equals')
    const runningTotal = container.getByTestId('running-total')
    fireEvent.click(button7);
    fireEvent.click(minusButton);
    fireEvent.click(button4);
    fireEvent.click(equalsButton);
    expect(runningTotal.textContent).toEqual('3');
  })

  it('3 * 5 should equal 15', () => {
    const button3 = container.getByTestId('number3');
    const multiplyButton = container.getByTestId('operator-multiply');
    const button5 = container.getByTestId('number5');
    const equalsButton = container.getByTestId('operator-equals');
    const runningTotal = container.getByTestId('running-total');
    fireEvent.click(button3);
    fireEvent.click(multiplyButton);
    fireEvent.click(button5);
    fireEvent.click(equalsButton);
    expect(runningTotal.textContent).toEqual('15');
  });
  
  it('21 / 7 should equal 3', () => {
    const button2 = container.getByTestId('number2');
    const button1 = container.getByTestId('number1');
    const divideButton = container.getByTestId('operator-divide');
    const button7 = container.getByTestId('number7');
    const equalsButton = container.getByTestId('operator-equals');
    const runningTotal = container.getByTestId('running-total');
    fireEvent.click(button2);
    fireEvent.click(button1);
    fireEvent.click(divideButton);
    fireEvent.click(button7);
    fireEvent.click(equalsButton);
    expect(runningTotal.textContent).toEqual('3');
  });

  it('should concatenate multiple number button clicks', () => {
    const button2 = container.getByTestId('number2');
    const button3 = container.getByTestId('number3');
    const runningTotal = container.getByTestId('running-total');
    fireEvent.click(button2);
    fireEvent.click(button3);
    expect(runningTotal.textContent).toEqual('23');
  });
  
  it('should chain multiple operations together', () => {
    const button2 = container.getByTestId('number2');
    const multiplyButton = container.getByTestId('operator-multiply');
    const button4 = container.getByTestId('number4');
    const addButton = container.getByTestId('operator-add');
    const button5 = container.getByTestId('number5');
    const equalsButton = container.getByTestId('operator-equals');
    const runningTotal = container.getByTestId('running-total');
    fireEvent.click(button2);
    fireEvent.click(multiplyButton);
    fireEvent.click(button4);
    fireEvent.click(addButton);
    fireEvent.click(button5);
    fireEvent.click(equalsButton);
    expect(runningTotal.textContent).toEqual('13');
  });
  
  it('should clear the running total without affecting the calculation', () => {
    const button2 = container.getByTestId('number2');
    const addButton = container.getByTestId('operator-add');
    const button3 = container.getByTestId('number3');
    const clearButton = container.getByTestId('clear');
    const runningTotal = container.getByTestId('running-total');
    fireEvent.click(button2);
    fireEvent.click(addButton);
    fireEvent.click(button3);
    fireEvent.click(clearButton);
    expect(runningTotal.textContent).toEqual('0');
  });
  
  


});








