describe('Home Tests', ()=>{
  it("open the home page and varify the url and the title", ()=>{
      cy.visit('https://www.google.com/');
      cy.get("#W0wltc").click();
      cy.get(".gLFyf.gsfi").type("dogs{enter}");
      cy.get("div#rso span em").each((item, index,list) => {
        expect(Cypress.$(item).text().slice(0, 3).toUpperCase()).to.eq('DOG');
      });
  }) 
})