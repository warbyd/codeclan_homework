describe("Calculator", () => {
  beforeEach(() => {
    cy.visit("http://localhost:3000");
  })

  it('should have working number buttons', () => {
    cy.get('#number2').click();
    cy.get('.display').should('contain', '2')
  })

  it('should update the display with the result of arithmetical operations', () => {
    cy.get('#number2').click();
    cy.get('#operator_add').click();
    cy.get('#number3').click();
    cy.get('#operator-equals').click();
    cy.get('.display', { timeout: 10000 }).should('contain', '5');
  });
  

  it('should allow chaining of multiple operations', () => {
    // Click number 3
    cy.get('#number3').click();
    // Click the addition operator
    cy.get('#operator-multiply').click();
    // Click number 1
    cy.get('#number1').click();
    // Click the subtraction operator
    cy.get('#operator-subtract').click();
    // Click number 2
    cy.get('#number2').click();
    // Click the equals operator
    cy.get('#operator-equals').click();
    // Verify the display shows 2 as the result (3 + 1 - 2 = 2)
    cy.get('.display').should('contain', '1');
  });

  it('should display output as expected for positive numbers', () => {
    cy.get('#number2').click();
    cy.get('#operator_add').click();
    cy.get('#number3').click();
    cy.get('#operator-equals').click();
    cy.get('.display').should('contain', '5')
  })

  it('should display output as expected for negative numbers', () => {
    cy.get('#number5').click();
    cy.get('#operator-subtract').click();
    cy.get('#number8').click();
    cy.get('#operator-equals').click();
    cy.get('.display').should('contain', '-3')
  })

  it('should display output as expected for decimal numbers', () => {
    cy.get('#number1').click();
    cy.get('#operator-divide').click();
    cy.get('#number3').click();
    cy.get('#operator-equals').click();
    cy.get('.display').should('contain', '0.3333333333333333')
  })

  it('should display output as expected for very large numbers', () => {
    cy.get('#number9').click();
    cy.get('#number9').click();
    cy.get('#operator-multiply').click();
    cy.get('#number1').click();
    cy.get('#number0').click();
    cy.get('#number0').click();
    cy.get('#number0').click();
    cy.get('#operator-equals').click();
    cy.get('.display').should('contain', '99000')
  })



});
