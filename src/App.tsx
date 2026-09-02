import React from 'react'

function App() {
  return (
    <div className="font-body-md text-on-surface antialiased pb-32 min-h-screen bg-black">
      {/* TopAppBar */}
      <header className="flex justify-between items-center px-container-margin py-4 w-full bg-background z-40 relative">
        <div className="flex items-center gap-3">
          <div className="w-10 h-10 rounded-full bg-surface-container-high border border-white/10 flex items-center justify-center overflow-hidden">
            <img
              alt="Avatar"
              className="w-full h-full object-cover"
              src="https://lh3.googleusercontent.com/aida-public/AB6AXuCTm93mgRH-2Vjig1hi1lt4yF2in-y3eR0OXORZAwKRWC7mnUofcSmEq7gsnpVLs3QaCS2tzVN0GOUH_81Q7fuCrsEVGPnOnWCVs5t6NAtp1KKBin6lh9tWz6z9docLRe4Haw-70f1menqIdzOWUPoejaVBSfpkWb_Ee7E21k16N0cIIHqWdAeoytdxo7gAGNEQoeEU3Bjlr7STyOHTflpo7cGCfAjk_cJZi5W8cgRTpC3jx90zj4cbBw"
            />
          </div>
          <div>
            <h1 className="text-on-surface font-bold tracking-tight text-xl">Hola, Jan</h1>
          </div>
        </div>
        <button className="w-10 h-10 flex items-center justify-center rounded-full bg-surface-secondary text-primary hover:opacity-80 transition-opacity active:scale-95 duration-100">
          <span className="material-symbols-outlined">search</span>
        </button>
      </header>

      <main className="px-container-margin flex flex-col gap-10 mt-4">
        {/* Cartera Section */}
        <section>
          <h2 className="text-text-muted text-sm mb-4 uppercase tracking-wider font-semibold">Mi cartera</h2>
          <div className="relative h-[220px] w-full">
            {/* Secondary Card (Back) */}
            <div className="absolute top-0 left-0 w-full h-[180px] radial-gradient-card rounded-[24px] p-6 flex flex-col justify-between translate-y-3 scale-95 opacity-80 z-0">
              <div className="flex justify-between items-start">
                <span className="text-[10px] tracking-widest text-text-muted uppercase font-bold">TOTAL VENTAS</span>
                <div className="w-8 h-8 rounded-lg bg-white/5 border border-white/10"></div>
              </div>
              <div>
                <div className="text-2xl font-bold text-white mb-1">$65,500</div>
                <div className="text-xs text-text-muted">3 cerradas</div>
              </div>
            </div>
            {/* Primary Card (Front) */}
            <div className="absolute top-0 left-0 w-full h-[200px] radial-gradient-card rounded-[24px] p-6 flex flex-col justify-between z-10 shadow-2xl border border-white/5">
              <div className="flex justify-between items-start">
                <span className="text-[10px] tracking-widest text-white uppercase opacity-90 font-bold">TOTAL PROSPECTOS</span>
                <div className="w-8 h-8 rounded-lg bg-white/10 border border-white/20 flex items-center justify-center backdrop-blur-md"></div>
              </div>
              <div>
                <div className="text-4xl font-bold text-white mb-1 tracking-tight">$119,350</div>
                <div className="text-xs text-text-muted">3 en seguimiento</div>
              </div>
            </div>
          </div>
        </section>

        {/* Chart Section */}
        <section className="radial-gradient-card rounded-[24px] p-6 border border-white/5 relative overflow-hidden">
          <div className="flex justify-between items-baseline mb-8 relative z-10">
            <h3 className="text-xl font-bold text-white">Ingresos</h3>
            <span className="text-xs text-text-muted">Últimos 6 meses</span>
          </div>
          <div className="relative h-[120px] w-full flex items-end">
            <div className="absolute bottom-0 left-0 w-full flex justify-between text-text-muted text-[10px] uppercase translate-y-6">
              <span>Mar</span><span>Abr</span><span>May</span><span>Jun</span><span>Jul</span><span>Ago</span>
            </div>
            <svg className="absolute bottom-0 w-full h-[100px] z-20 overflow-visible" preserveAspectRatio="none" viewBox="0 0 100 100">
              <path d="M0,90 Q20,90 40,90 T60,85 T80,40 T100,10" fill="none" stroke="white" strokeWidth="2" vectorEffect="non-scaling-stroke"></path>
              <circle cx="0" cy="90" fill="white" r="2.5"></circle>
              <circle cx="20" cy="90" fill="white" r="2.5"></circle>
              <circle cx="40" cy="90" fill="white" r="2.5"></circle>
              <circle cx="60" cy="85" fill="white" r="2.5"></circle>
              <circle cx="80" cy="40" fill="white" r="2.5"></circle>
              <circle cx="100" cy="10" fill="white" r="4"></circle>
            </svg>
            <svg className="absolute bottom-0 w-full h-[100px] z-10 opacity-40" preserveAspectRatio="none" viewBox="0 0 100 100">
              <defs>
                <linearGradient id="chartFill" x1="0" x2="0" y1="0" y2="1">
                  <stop offset="0%" stopColor="white" stopOpacity="0.3"></stop>
                  <stop offset="100%" stopColor="white" stopOpacity="0"></stop>
                </linearGradient>
              </defs>
              <path d="M0,90 Q20,90 40,90 T60,85 T80,40 T100,10 L100,100 L0,100 Z" fill="url(#chartFill)"></path>
            </svg>
          </div>
          <div className="h-6"></div>
        </section>

        {/* Resumen de Contactos */}
        <section>
          <h2 className="text-text-muted text-sm mb-4 font-semibold">Resumen de contactos</h2>
          <div className="flex flex-col gap-3">
            {[
              { label: 'Leads', count: 12, active: false },
              { label: 'Interesados', count: 8, active: false },
              { label: 'Ventas', count: 45, active: true },
            ].map((item, idx) => (
              <div
                key={idx}
                className={`${item.active ? 'bg-white text-black' : 'bg-surface-secondary text-white'} rounded-[20px] p-5 flex justify-between items-center border border-white/5 shadow-lg`}
              >
                <div className="flex items-center gap-3">
                  <div className={`w-2 h-2 rounded-full ${item.active ? 'bg-black' : 'bg-text-muted'}`}></div>
                  <span className="font-semibold">{item.label}</span>
                </div>
                <span className="text-lg font-bold">{item.count}</span>
              </div>
            ))}
          </div>
        </section>
      </main>

      {/* BottomNavBar */}
      <nav className="fixed bottom-8 left-1/2 -translate-x-1/2 z-50 flex justify-between items-center px-2 py-2 bg-black/80 backdrop-blur-xl rounded-full w-[90%] max-w-md border border-white/10 shadow-xl">
        <a className="flex items-center gap-2 bg-white text-black rounded-full px-6 py-3 transition-all duration-300" href="#">
          <span className="material-symbols-outlined">home</span>
          <span className="text-sm font-semibold">Inicio</span>
        </a>
        <a className="flex items-center justify-center text-text-muted p-3 hover:text-white transition-colors" href="#">
          <span className="material-symbols-outlined">person</span>
        </a>
        <a className="flex items-center justify-center text-text-muted p-3 hover:text-white transition-colors" href="#">
          <span className="material-symbols-outlined">check_box</span>
        </a>
        <a className="flex items-center justify-center text-text-muted p-3 hover:text-white transition-colors" href="#">
          <span className="material-symbols-outlined">settings</span>
        </a>
      </nav>
    </div>
  )
}

export default App
