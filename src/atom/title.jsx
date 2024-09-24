import React from 'react';

const Title = ({title}) => {
    return (
        <h1 className='text-3xl font-bold text-default tracking-tight sm:text-3xl'>
            {title} 
        </h1>
    );
};

export default Title;