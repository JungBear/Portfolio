import logo from './logo.svg';
import './App.css';
import Layout from './components/Layout/layout';
import AboutMe from './components/AboutMe/aboutMe';
import Project from './components/Project/project';
import Others from './components/Others/others';

function App() {
  return (
    <div className='w-full mt-8 px-20 py-10'>
        <AboutMe />
        <Project />
        <Others />
    </div>
  );
}

export default App;
