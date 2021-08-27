let logoutButton = document.getElementById('logout');
//const currentUserObject;
let typeInput = document.getElementById('type');

let statusInput = document.getElementById('status');

const logout = (event) => {
    event.preventDefault(); //prevents default behavior

    fetch('http://localhost:7000/logout', {
        'method': 'POST',
        'credentials': 'include', //specifies that when you receive cookies you should include them in requests
    }).then((response) => {
        if(response.status === 200){
            window.location.href = '/index.html';
        }
    })
};

const statusButton = (event) => {
    event.preventDefault(); //prevents default behavior


    fetch('http://localhost:7000/currentuser', {
        'method': 'GET',
        'credentials': 'include',
    }).then((response) => {
        if(response.status === 401){
            window.location.href = '/index.html'
        } 
        else if (response.status === 200){
            return response.json();
        }
    }).then((user) => {

        if(user.userRole.uID != 2){
            window.location.href = '/index.html'
        };

        if(typeInput.value == "all"){

            var Table = document.getElementById("innerTable");
            Table.innerHTML = "";


        return fetch(`http://localhost:7000/reimbursements`, {
        'method': 'GET',
        'credentials': 'include'
        });

        } else if(typeInput.value == "aproved"){

            var Table = document.getElementById("innerTable");
            Table.innerHTML = "";

        return fetch(`http://localhost:7000/filterByStatus/1`, {
        'method': 'GET',
        'credentials': 'include'
        });
        } else if(typeInput.value == "denied"){

            var Table = document.getElementById("innerTable");
            Table.innerHTML = "";

            return fetch(`http://localhost:7000/filterByStatus/2`, {
            'method': 'GET',
            'credentials': 'include'
            });
        } else if(typeInput.value == "pending"){

            var Table = document.getElementById("innerTable");
            Table.innerHTML = "";

            return fetch(`http://localhost:7000/filterByStatus/3`, {
            'method': 'GET',
            'credentials': 'include'
            });
        }

    }).then((response) => {
       return response.json()
    }).then((reimbursements) =>{
        populateReimbursements(reimbursements)
    })
};

function onLoad(event){
    fetch('http://localhost:7000/currentuser', {
        'method': 'GET',
        'credentials': 'include',
    }).then((response) => {
        if(response.status === 401){
            window.location.href = '/index.html'
        } 
        else if (response.status === 200){
            return response.json();
        }
    }).then((user) => {

        if(user.userRole.uID != 2){
            window.location.href = '/index.html'
        };

        if(typeInput.value == "all"){

        return fetch(`http://localhost:7000/reimbursements`, {
        'method': 'GET',
        'credentials': 'include'
        });

        } else if(typeInput.value == "aproved"){

        return fetch(`http://localhost:7000/filterByStatus/1`, {
        'method': 'GET',
        'credentials': 'include'
        });
        } else if(typeInput.value == "denied"){

            return fetch(`http://localhost:7000/filterByStatus/2`, {
            'method': 'GET',
            'credentials': 'include'
            });
        } else if(typeInput.value == "pending"){

            return fetch(`http://localhost:7000/filterByStatus/3`, {
            'method': 'GET',
            'credentials': 'include'
            });
        }

    }).then((response) => {
       return response.json()
    }).then((reimbursements) =>{
        populateReimbursements(reimbursements)
    })
}

// function onLoad(event){
//     fetch('http://localhost:7000/currentuser', {
//         'method': 'GET',
//         'credentials': 'include',
//     }).then((response) => {
//         if(response.status === 401){
//             window.location.href = '/index.html'
//         } 
//         else if (response.status === 200){
//             return response.json();
//         }
//     }).then(() => {
//         return fetch(`http://localhost:7000/reimbursements`, {
//         'method': 'GET',
//         'credentials': 'include'
//         });
//     }).then((response) => {
//        return response.json()
//     }).then((reimbursements) =>{
//         populateReimbursements(reimbursements)
//     })
// }

function populateReimbursements(reimArray){
    //let reimSection = document.getElementById('reimbursements')
    let tbody = document.querySelector('#reimbursements tbody'); 

    for (const reim of reimArray){
       let tr = document.createElement('tr');
       
       let reimID = document.createElement('td');
       reimID.innerHTML = reim.rID;

       let reimType = document.createElement('td');
       reimType.innerHTML = reim.rType.rType;

       let reimDate = document.createElement('td');
       reimDate.innerHTML = reim.rSub;

       let reimAmount = document.createElement('td');
       reimAmount.innerHTML = reim.rAmount;

       let reimDesc = document.createElement('td');
       reimDesc.innerHTML = reim.desc;

       let reimStatus = document.createElement('td');
       reimStatus.innerHTML = reim.rStatus.rStatus;
      

        tr.appendChild(reimID);
        tr.appendChild(reimType);
        tr.appendChild(reimDate);
        tr.appendChild(reimAmount);
        tr.appendChild(reimDesc);
        tr.appendChild(reimStatus);
        

        tbody.appendChild(tr);
    }
}

logoutButton.addEventListener('click', logout);
window.addEventListener('load', onLoad)
statusInput.addEventListener('click', statusButton)